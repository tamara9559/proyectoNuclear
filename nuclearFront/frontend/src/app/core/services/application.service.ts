import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Application } from '../models/application.model';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private http = inject(HttpClient);

  private api =
    'https://zealous-emotion-production-bfb7.up.railway.app/api/applications';

  apply(
    application: Application
  ): Observable<Application> {

    return this.http.post<Application>(
      this.api,
      application
    );
  }

  findById(
    id: number
  ): Observable<Application> {

    return this.http.get<Application>(
      `${this.api}/${id}`
    );
  }

  findAll(): Observable<Application[]> {

    return this.http.get<Application[]>(
      this.api
    );
  }

  findByUser(
    userId: number
  ): Observable<Application[]> {

    return this.http.get<Application[]>(
      `${this.api}/user/${userId}`
    );
  }

  findByVacancy(
    vacancyId: number
  ): Observable<Application[]> {

    return this.http.get<Application[]>(
      `${this.api}/vacancy/${vacancyId}`
    );
  }

}