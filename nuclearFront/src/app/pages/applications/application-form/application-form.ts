import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
ReactiveFormsModule,
FormBuilder,
Validators
} from '@angular/forms';

import {
Router
} from '@angular/router';

import {
ApplicationService
} from '../../../core/services/application.service';

import {
Application
} from '../../../core/models/application.model';

@Component({

selector:
'app-application-form',

standalone:
true,

imports: [

CommonModule,
ReactiveFormsModule

],

templateUrl:
'./application-form.html',

styleUrl:
'./application-form.css'

})

export class ApplicationForm {

private fb =
inject(FormBuilder);

private service =
inject(ApplicationService);

private router =
inject(Router);

form =
this.fb.group({

usuarioId: [
0,
Validators.required
],

vacanteId: [
0,
Validators.required
]

});

save(): void {

if (
this.form.invalid
) {

this.form.markAllAsTouched();

return;

}

const application: Application = {

usuarioId:
this.form.value.usuarioId!,

vacanteId:
this.form.value.vacanteId!,

estado:
'ENVIADA',

fechaPostulacion:
new Date().toISOString(),

observaciones:
''

};

this.service
.apply(application)

.subscribe(() => {

this.router.navigate([
'/applications'
]);

});

}

cancel(): void {

this.router.navigate([
'/applications'
]);

}

}