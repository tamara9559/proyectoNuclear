import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import {
  Observable,
  tap
} from 'rxjs';

export interface LoginRequest {

  correo: string;

  password: string;

}

export interface LoginResponse {

  token: string;

  userId: number;

  correo: string;

  rol: string;

}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private http =
    inject(HttpClient);

  private api =
    'http://localhost:8080/api/auth';

  login(
    data: LoginRequest
  ): Observable<LoginResponse> {

    return this.http
      .post<LoginResponse>(
        `${this.api}/login`,
        data
      )
      .pipe(

        tap(
          response => {

            localStorage.setItem(
              'token',
              response.token
            );

            localStorage.setItem(
  'rol',
  response.rol.startsWith('ROLE_')
    ? response.rol.replace('ROLE_', '')
    : response.rol
);

            localStorage.setItem(
              'correo',
              response.correo
            );

            localStorage.setItem(
'userid',
String(
response.userId
)
);
          }
          
        )

      );

  }

  logout(): void {

    localStorage.clear();

  }

  isLogged(): boolean {

    return !!localStorage.getItem(
      'token'
    );

  }

  getToken(): string {

    return localStorage.getItem(
      'token'
    ) ?? '';

  }

  getRole(): string {
  const role = localStorage.getItem('rol') ?? '';
  return role.replace('ROLE_', '');
}

  getUserId(): number {

return Number(

localStorage.getItem(
'userid'
)

);

}

}