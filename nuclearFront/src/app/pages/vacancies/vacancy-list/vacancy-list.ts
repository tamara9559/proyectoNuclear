import {
  Component,
  OnInit,
  inject
} from '@angular/core';

import {
  CommonModule
} from '@angular/common';

import {
  Vacancy
} from '../../../core/models/vacancy.model';

import {
  VacancyService
} from '../../../core/services/vacancy.service';

@Component({
  selector: 'app-vacancy-list',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './vacancy-list.html',
  styleUrl: './vacancy-list.css'
})
export class VacancyList
implements OnInit {

  private vacancyService =
    inject(VacancyService);

  vacancies:
    Vacancy[] = [];

  ngOnInit(): void {

    this.loadVacancies();

  }

  loadVacancies(): void {

    this.vacancyService
      .findAll()
      .subscribe({

        next: (data) => {

          this.vacancies =
            data;

        },

        error: (err) => {

          console.error(
            'Error cargando vacantes',
            err
          );

        }

      });

  }

}