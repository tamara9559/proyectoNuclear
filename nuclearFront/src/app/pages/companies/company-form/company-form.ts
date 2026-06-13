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
  CompanyService
} from '../../../core/services/company.service';

import {
  Company
} from '../../../core/models/company.model';

@Component({
  selector: 'app-company-form',

  standalone: true,

  imports: [
    CommonModule,
    ReactiveFormsModule
  ],

  templateUrl: './company-form.html',

  styleUrl: './company-form.css'
})

export class CompanyForm
implements OnInit {

  private fb =
    inject(FormBuilder);

  private companyService =
    inject(CompanyService);

  private route =
    inject(ActivatedRoute);

  private router =
    inject(Router);

  editing =
    false;

  companyId?:
    number;

  form =
    this.fb.group({

      usuarioId: [
        0,
        Validators.required
      ],

      razonSocial: [
        '',
        Validators.required
      ],

      nit: [
        '',
        Validators.required
      ],

      sector: [
        ''
      ],

      direccion: [
        ''
      ],

      ciudad: [
        ''
      ],

      telefono: [
        ''
      ],

      correoContacto: [
        '',
        Validators.email
      ],

      representanteLegal: [
        ''
      ],

      estado: [
        true
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

      this.companyId =
        Number(id);

      this.loadCompany();

    }

  }

  loadCompany(): void {

    this.companyService
      .findById(
        this.companyId!
      )
      .subscribe(company => {

        this.form.patchValue({

          usuarioId:
            company.usuarioId,

          razonSocial:
            company.razonSocial,

          nit:
            company.nit,

          sector:
            company.sector,

          direccion:
            company.direccion,

          ciudad:
            company.ciudad,

          telefono:
            company.telefono,

          correoContacto:
            company.correoContacto,

          representanteLegal:
            company.representanteLegal,

          estado:
            company.estado

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

    const company =
      this.form.value as Company;

    if (
      this.editing
    ) {

      this.companyService
        .update(
          this.companyId!,
          company
        )
        .subscribe(() => {

          this.router.navigate([
            '/companies'
          ]);

        });

    }

    else {

      this.companyService
        .create(
          company
        )
        .subscribe(() => {

          this.router.navigate([
            '/companies'
          ]);

        });

    }

  }

  cancel(): void {

  this.router.navigate([
    '/companies'
  ]);

}

}