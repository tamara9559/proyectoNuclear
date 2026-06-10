import {
  Component,
  OnInit,
  inject
} from '@angular/core';

import {
  FormBuilder,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import {
  ActivatedRoute,
  Router
} from '@angular/router';

import {
  CommonModule
} from '@angular/common';

import {
  UserService
} from '../../../core/services/user.service';

import {
  User
} from '../../../core/models/user.model';

@Component({
  selector: 'app-user-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './user-form.html',
  styleUrl: './user-form.css'
})
export class UserForm implements OnInit {

  private fb =
    inject(FormBuilder);

  private userService =
    inject(UserService);

  private route =
    inject(ActivatedRoute);

  private router =
    inject(Router);

  editing = false;

  userId?: number;

  form =
    this.fb.group({

      nombres: [
        '',
        Validators.required
      ],

      apellidos: [
        '',
        Validators.required
      ],

      correo: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],

      password: [
        ''
      ],

      telefono: [
        ''
      ],

      rol: [
        '',
        Validators.required
      ],

      estado: [
        true
      ]

    });

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get(
        'id'
      );

    if (id) {

      this.editing =
        true;

      this.userId =
        Number(id);

      this.loadUser();

    }

  }

  loadUser(): void {

    this.userService
      .findById(
        this.userId!
      )
      .subscribe(user => {

        this.form.patchValue({

          nombres:
            user.nombres,

          apellidos:
            user.apellidos,

          correo:
            user.correo,

          telefono:
            user.telefono,

          rol:
            user.rol,

          estado:
            user.estado

        });

      });

  }

  save(): void {

    if (
      this.form.invalid
    ) {

      this.form.markAllAsTouched();

      return;

    }

    const user =
      this.form.value as User;

    if (
      this.editing
    ) {

      this.userService
        .update(
          this.userId!,
          user
        )
        .subscribe(() => {

          this.router.navigate([
            '/users'
          ]);

        });

    } else {

      this.userService
        .create(
          user
        )
        .subscribe(() => {

          this.router.navigate([
            '/users'
          ]);

        });

    }

  }

}