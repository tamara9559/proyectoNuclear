import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Evaluation } from '../models/evaluation.model';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  private http = inject(HttpClient);

  private api =
    'http://zealous-emotion-production-bfb7.up.railway.app/api/evaluations';

  create(
    evaluation: Evaluation
  ): Observable<Evaluation> {

    return this.http.post<Evaluation>(
      this.api,
      evaluation
    );
  }

  update(
    id: number,
    evaluation: Evaluation
  ): Observable<Evaluation> {

    return this.http.put<Evaluation>(
      `${this.api}/${id}`,
      evaluation
    );
  }

  findById(
    id: number
  ): Observable<Evaluation> {

    return this.http.get<Evaluation>(
      `${this.api}/${id}`
    );
  }

  findByPractice(
    practiceId: number
  ): Observable<Evaluation[]> {

    return this.http.get<Evaluation[]>(
      `${this.api}/practice/${practiceId}`
    );
  }

  average(
    practiceId: number
  ): Observable<number> {

    return this.http.get<number>(
      `${this.api}/average/${practiceId}`
    );
  }

}