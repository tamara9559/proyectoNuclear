import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import {
  Practice
} from '../models/practice.model';

@Injectable({
  providedIn: 'root'
})
export class PracticeService {

  private http = inject(HttpClient);

  private api =
    'https://zealous-emotion-production-bfb7.up.railway.app/api/practices';

  create(
    practice: Practice
  ): Observable<Practice> {

    return this.http.post<Practice>(
      this.api,
      practice
    );
  }

  update(
    id: number,
    practice: Practice
  ): Observable<Practice> {

    return this.http.put<Practice>(
      `${this.api}/${id}`,
      practice
    );
  }

  findById(
    id: number
  ): Observable<Practice> {

    return this.http.get<Practice>(
      `${this.api}/${id}`
    );
  }

  findAll(
  ): Observable<Practice[]> {

    return this.http.get<Practice[]>(
      this.api
    );
  }

  startPractice(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/start`,
      {}
    );
  }

  finishPractice(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/finish`,
      {}
    );
  }

  registerMobility(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/mobility`,
      {}
    );
  }

  cancel(
    id: number,
    reason: string
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/cancel`,
      {},
      {
        params: {
          reason
        }
      }
    );
  }

  duration(
    id: number
  ): Observable<number> {

    return this.http.get<number>(
      `${this.api}/${id}/duration`
    );
  }

}