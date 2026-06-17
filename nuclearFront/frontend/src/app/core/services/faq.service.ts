import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import {
  FAQ
} from '../models/faq.model';

@Injectable({
  providedIn: 'root'
})
export class FaqService {

  private http = inject(HttpClient);

  private api =
    'http://zealous-emotion-production-bfb7.up.railway.app/api/faqs';

  create(
    faq: FAQ
  ): Observable<FAQ> {

    return this.http.post<FAQ>(
      this.api,
      faq
    );
  }

  update(
    id: number,
    faq: FAQ
  ): Observable<FAQ> {

    return this.http.put<FAQ>(
      `${this.api}/${id}`,
      faq
    );
  }

  findById(
    id: number
  ): Observable<FAQ> {

    return this.http.get<FAQ>(
      `${this.api}/${id}`
    );
  }

  findAll(
  ): Observable<FAQ[]> {

    return this.http.get<FAQ[]>(
      this.api
    );
  }

  findByCategory(
    category: string
  ): Observable<FAQ[]> {

    return this.http.get<FAQ[]>(
      `${this.api}/category/${category}`
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

  deactivate(
    id: number
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/deactivate`,
      {}
    );
  }

}