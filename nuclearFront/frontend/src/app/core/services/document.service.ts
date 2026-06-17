import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Document } from '../models/document.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  private http = inject(HttpClient);

  private api =
    'https://zealous-emotion-production-bfb7.up.railway.app/api/documents';

  upload(
    document: Document
  ): Observable<Document> {

    return this.http.post<Document>(
      this.api,
      document
    );
  }

  findById(
    id: number
  ): Observable<Document> {

    return this.http.get<Document>(
      `${this.api}/${id}`
    );
  }

  findByStudent(
    studentId: number
  ): Observable<Document[]> {

    return this.http.get<Document[]>(
      `${this.api}/student/${studentId}`
    );
  }

  findByCompany(
    companyId: number
  ): Observable<Document[]> {

    return this.http.get<Document[]>(
      `${this.api}/company/${companyId}`
    );
  }

  findByAgreement(
    agreementId: number
  ): Observable<Document[]> {

    return this.http.get<Document[]>(
      `${this.api}/agreement/${agreementId}`
    );
  }

  delete(
    id: number
  ): Observable<void> {

    return this.http.delete<void>(
      `${this.api}/${id}`
    );
  }

  generateAgreement(
    agreementId: number
  ): Observable<string> {

    return this.http.get(
      `${this.api}/generate/agreement/${agreementId}`,
      {
        responseType: 'text'
      }
    );
  }

  generateLearningContract(
    practiceId: number
  ): Observable<string> {

    return this.http.get(
      `${this.api}/generate/learning-contract/${practiceId}`,
      {
        responseType: 'text'
      }
    );
  }

  generateMobility(
    practiceId: number
  ): Observable<string> {

    return this.http.get(
      `${this.api}/generate/mobility/${practiceId}`,
      {
        responseType: 'text'
      }
    );
  }

}