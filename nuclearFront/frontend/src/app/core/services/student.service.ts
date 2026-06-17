import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private http = inject(HttpClient);

  private api =
    'https://proyectonuclear-production.up.railway.app/api/students';

  create(
    student: Student
  ): Observable<Student> {

    return this.http.post<Student>(
      this.api,
      student
    );
  }

  update(
    id: number,
    student: Student
  ): Observable<Student> {

    return this.http.put<Student>(
      `${this.api}/${id}`,
      student
    );
  }

  findById(
    id: number
  ): Observable<Student> {

    return this.http.get<Student>(
      `${this.api}/${id}`
    );
  }

  findAll(): Observable<Student[]> {

    return this.http.get<Student[]>(
      this.api
    );
  }

  findByCareer(
    career: string
  ): Observable<Student[]> {

    return this.http.get<Student[]>(
      `${this.api}/career/${career}`
    );
  }

  findByAvailability(
    availability: string
  ): Observable<Student[]> {

    return this.http.get<Student[]>(
      `${this.api}/availability/${availability}`
    );
  }

  findBySkills(
    skills: string
  ): Observable<Student[]> {

    return this.http.get<Student[]>(
      `${this.api}/skills/${skills}`
    );
  }

  findByCompetencies(
    competencies: string
  ): Observable<Student[]> {

    return this.http.get<Student[]>(
      `${this.api}/competencies/${competencies}`
    );
  }

  updateStatus(
    id: number,
    status: string
  ): Observable<void> {

    return this.http.put<void>(
      `${this.api}/${id}/status?status=${status}`,
      {}
    );
  }

}