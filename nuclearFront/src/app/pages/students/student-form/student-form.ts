import {
  Component,
  OnInit,
  inject
} from '@angular/core';

import {
  CommonModule
} from '@angular/common';

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
  StudentService
} from '../../../core/services/student.service';

import {
  Student
} from '../../../core/models/student.model';

@Component({
  selector: 'app-student-form',

  standalone: true,

  imports: [
    CommonModule,
    ReactiveFormsModule
  ],

  templateUrl:
    './student-form.html',

  styleUrl:
    './student-form.css'
})

export class StudentForm
implements OnInit {

  private fb =
    inject(FormBuilder);

  private service =
    inject(StudentService);

  private route =
    inject(ActivatedRoute);

  private router =
    inject(Router);

  editing =
    false;

  studentId?:
    number;

  form =
    this.fb.group({

      usuarioId: [
        0,
        Validators.required
      ],

      codigoEstudiantil: [
        '',
        Validators.required
      ],

      carrera: [
        '',
        Validators.required
      ],

      semestre: [
        1,
        Validators.required
      ],

      promedio: [
        0
      ],

      descripcionPerfil: [
        ''
      ],

      competencias: [
        ''
      ],

      habilidades: [
        ''
      ],

      disponibilidad: [
        ''
      ],

      ciudad: [
        ''
      ],

      hojaVidaUrl: [
        ''
      ],

      estadoPractica: [
        'SIN_PRACTICA'
      ]

    });

  ngOnInit(): void {

    const id =
      this.route
      .snapshot
      .paramMap
      .get('id');

    if (id) {

      this.editing =
        true;

      this.studentId =
        Number(id);

      this.loadStudent();

    }

  }

  loadStudent(): void {

    this.service
      .findById(
        this.studentId!
      )
      .subscribe(student => {

        this.form.patchValue({

          usuarioId:
            student.usuarioId,

          codigoEstudiantil:
            student.codigoEstudiantil,

          carrera:
            student.carrera,

          semestre:
            student.semestre,

          promedio:
            student.promedio,

          descripcionPerfil:
            student.descripcionPerfil,

          competencias:
            student.competencias,

          habilidades:
            student.habilidades,

          disponibilidad:
            student.disponibilidad,

          ciudad:
            student.ciudad,

          hojaVidaUrl:
            student.hojaVidaUrl,

          estadoPractica:
            student.estadoPractica

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

    const student =
      this.form.value as Student;

    if (
      this.editing
    ) {

      this.service
        .update(
          this.studentId!,
          student
        )
        .subscribe(() => {

          this.router.navigate([
            '/students'
          ]);

        });

    }

    else {

      this.service
        .create(
          student
        )
        .subscribe(() => {

          this.router.navigate([
            '/students'
          ]);

        });

    }

  }

}