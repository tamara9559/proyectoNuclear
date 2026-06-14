import {
Component,
OnInit,
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
ActivatedRoute,
Router
} from '@angular/router';

import {
PracticeService
} from '../../../core/services/practice.service';

import {
Practice
} from '../../../core/models/practice.model';

@Component({

selector:
'app-practice-form',

standalone:
true,

imports: [
CommonModule,
ReactiveFormsModule
],

templateUrl:
'./practice-form.html',

styleUrl:
'./practice-form.css'

})

export class PracticeForm
implements OnInit {

private fb =
inject(FormBuilder);

private service =
inject(PracticeService);

private route =
inject(ActivatedRoute);

private router =
inject(Router);

editing =
false;

practiceId?:
number;

form =
this.fb.group({

estudianteId: [
0,
Validators.required
],

empresaId: [
0,
Validators.required
],

vacanteId: [
0,
Validators.required
],

convenioId: [
0,
Validators.required
],

ciudad: [''],

tutorEmpresarial: [''],

correoTutor: [''],

tipoContrato: [''],

fechaInicio: [''],

fechaFin: [''],

duracionSemanas: [0],

estado: ['PENDIENTE'],

requiereMovilidad: [false],

observaciones: ['']

});

ngOnInit(): void {

const id =
this.route
.snapshot
.paramMap
.get('id');

if (id) {

this.editing =
true;

this.practiceId =
Number(id);

this.load();

}

}

load(): void {

this.service
.findById(
this.practiceId!
)

.subscribe(data => {

this.form.patchValue(
data
);

});

}

save(): void {

if (
this.form.invalid
) {

this.form.markAllAsTouched();

return;

}

const practice: Practice = {

id:
this.practiceId,

estudianteId:
this.form.value.estudianteId!,

empresaId:
this.form.value.empresaId!,

vacanteId:
this.form.value.vacanteId!,

convenioId:
this.form.value.convenioId!,

ciudad:
this.form.value.ciudad!,

tutorEmpresarial:
this.form.value.tutorEmpresarial!,

correoTutor:
this.form.value.correoTutor!,

tipoContrato:
this.form.value.tipoContrato!,

fechaInicio:
this.form.value.fechaInicio!,

fechaFin:
this.form.value.fechaFin!,

duracionSemanas:
this.form.value.duracionSemanas!,

estado:
this.form.value.estado!,

requiereMovilidad:
this.form.value.requiereMovilidad!,

observaciones:
this.form.value.observaciones!

};

if (
this.editing
) {

this.service
.update(
this.practiceId!,
practice
)

.subscribe(() => {

this.router.navigate([
'/practices'
]);

});

}

else {

this.service
.create(
practice
)

.subscribe(() => {

this.router.navigate([
'/practices'
]);

});

}

}
cancel(): void {

this.router.navigate([
'/practices'
]);

}

}