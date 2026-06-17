import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Agreement } from '../models/agreement.model';

@Injectable({
  providedIn: 'root'
})
export class AgreementService {

  private http = inject(HttpClient);

  private api =
    'https://proyectonuclear-production.up.railway.app/api/agreements';

  create(
    agreement: Agreement
  ): Observable<Agreement> {

    return this.http.post<Agreement>(
      this.api,
      agreement
    );
  }

  update(
    id: number,
    agreement: Agreement
  ): Observable<Agreement> {

    return this.http.put<Agreement>(
      `${this.api}/${id}`,
      agreement
    );
  }

  findById(
    id: number
  ): Observable<Agreement> {

    return this.http.get<Agreement>(
      `${this.api}/${id}`
    );
  }

  findAll(): Observable<Agreement[]> {

    return this.http.get<Agreement[]>(
      this.api
    );
  }

  validate(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/validate`,
      {}
    );
  }

  signCompany(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/sign-company`,
      {}
    );
  }

  signUniversity(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/sign-university`,
      {}
    );
  }

  signStudent(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/sign-student`,
      {}
    );
  }

  activate(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/activate`,
      {}
    );
  }

}