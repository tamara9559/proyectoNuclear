import {
  Component,
  inject
}
from '@angular/core';

import {
  FormBuilder,
  ReactiveFormsModule
}
from '@angular/forms';

import {
  Router
}
from '@angular/router';

import {
  AuthService
}
from '../../core/services/auth.service';

@Component({

  selector:
    'app-login',

  imports: [

    ReactiveFormsModule

  ],

  templateUrl:
    './login.html'

})
export class Login {

  private fb =
    inject(
      FormBuilder
    );

  private auth =
    inject(
      AuthService
    );

  private router =
    inject(
      Router
    );

  form =
    this.fb.group({

      correo:
        [''],

      password:
        ['']

    });

  submit(): void {

    this.auth
      .login(

        {

          correo:
            this.form.value.correo!,

          password:
            this.form.value.password!

        }

      )

      .subscribe({

        next:
          () => {

            this.router.navigate(
              [
                '/dashboard'
              ]
            );

          },

        error:
          () => {

            alert(
              'Credenciales inválidas'
            );

          }

      });

  }

}