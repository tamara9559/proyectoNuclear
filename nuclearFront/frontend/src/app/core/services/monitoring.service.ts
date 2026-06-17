import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import {
  Monitoring
} from '../models/monitoring.model';

@Injectable({
  providedIn: 'root'
})
export class MonitoringService {

  private http = inject(HttpClient);

  private api =
    'https://proyectonuclear-production.up.railway.app/api/monitorings';

  registerVisit(
    monitoring: Monitoring
  ): Observable<Monitoring> {

    return this.http.post<Monitoring>(
      `${this.api}/visit`,
      monitoring
    );
  }

  registerObservation(
    monitoring: Monitoring
  ): Observable<Monitoring> {

    return this.http.post<Monitoring>(
      `${this.api}/observation`,
      monitoring
    );
  }

  registerMeeting(
    monitoring: Monitoring
  ): Observable<Monitoring> {

    return this.http.post<Monitoring>(
      `${this.api}/meeting`,
      monitoring
    );
  }

  registerCall(
    monitoring: Monitoring
  ): Observable<Monitoring> {

    return this.http.post<Monitoring>(
      `${this.api}/call`,
      monitoring
    );
  }

  findByPractice(
    practiceId: number
  ): Observable<Monitoring[]> {

    return this.http.get<Monitoring[]>(
      `${this.api}/practice/${practiceId}`
    );
  }

  findByCoordinator(
    coordinatorId: number
  ): Observable<Monitoring[]> {

    return this.http.get<Monitoring[]>(
      `${this.api}/coordinator/${coordinatorId}`
    );
  }

  history(
    practiceId: number
  ): Observable<Monitoring[]> {

    return this.http.get<Monitoring[]>(
      `${this.api}/history/${practiceId}`
    );
  }

}