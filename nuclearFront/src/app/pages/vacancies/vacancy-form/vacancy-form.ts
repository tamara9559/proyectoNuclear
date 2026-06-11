import {
Component,
OnInit,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
FormBuilder,
ReactiveFormsModule,
Validators
} from '@angular/forms';

import {
ActivatedRoute,
Router
} from '@angular/router';

import {
VacancyService
} from '../../../core/services/vacancy.service';

import {
Vacancy
} from '../../../core/models/vacancy.model';

@Component({

selector:
'app-vacancy-form',

standalone:
true,

imports: [

CommonModule,
ReactiveFormsModule

],

templateUrl:
'./vacancy-form.html',

styleUrl:
'./vacancy-form.css'

})

export class VacancyForm
implements OnInit {

private fb =
inject(
FormBuilder
);

private service =
inject(
VacancyService
);

private route =
inject(
ActivatedRoute
);

private router =
inject(
Router
);

editing =
false;

vacancyId?:
number;

form =
this.fb.group({

empresaId: [
0,
Validators.required
],

titulo: [
'',
Validators.required
],

descripcion: [
''
],

perfilRequerido: [
''
],

habilidadesRequeridas: [
''
],

carreraRequerida: [
''
],

tipoVacante: [
'',
Validators.required
],

modalidad: [
''
],

ciudad: [
''
],

remuneracion: [
0
],

cupos: [
1
],

estado: [
'ABIERTA'
],

fechaCierre: [
''
]

});

ngOnInit(): void {

const id =
this.route
.snapshot
.paramMap
.get(
'id'
);

if (
id
) {

this.editing =
true;

this.vacancyId =
Number(
id
);

this.loadVacancy();

}

}

loadVacancy(): void {

this.service
.findById(
this.vacancyId!
)

.subscribe(

vacancy => {

this.form.patchValue({

empresaId:
vacancy.empresaId,

titulo:
vacancy.titulo,

descripcion:
vacancy.descripcion,

perfilRequerido:
vacancy.perfilRequerido,

habilidadesRequeridas:
vacancy.habilidadesRequeridas,

carreraRequerida:
vacancy.carreraRequerida,

tipoVacante:
vacancy.tipoVacante,

modalidad:
vacancy.modalidad,

ciudad:
vacancy.ciudad,

remuneracion:
vacancy.remuneracion,

cupos:
vacancy.cupos,

estado:
vacancy.estado,

fechaCierre:
vacancy.fechaCierre

});

}

);

}

save(): void {

if (
this.form.invalid
) {

this.form
.markAllAsTouched();

return;

}

const vacancy: Vacancy = {

id:
this.vacancyId,

empresaId:
this.form.value.empresaId!,

titulo:
this.form.value.titulo!,

descripcion:
this.form.value.descripcion!,

perfilRequerido:
this.form.value.perfilRequerido!,

habilidadesRequeridas:
this.form.value.habilidadesRequeridas!,

carreraRequerida:
this.form.value.carreraRequerida!,

tipoVacante:
this.form.value.tipoVacante!,

modalidad:
this.form.value.modalidad!,

ciudad:
this.form.value.ciudad!,

remuneracion:
this.form.value.remuneracion!,

cupos:
this.form.value.cupos!,

estado:
this.form.value.estado!,

fechaPublicacion:
new Date().toISOString(),

fechaCierre:
this.form.value.fechaCierre!

};

if (
this.editing
) {

this.service
.update(

this.vacancyId!,
vacancy

)

.subscribe(() => {

this.router.navigate([

'/vacancies'

]);

});

}

else {

this.service
.create(

vacancy

)

.subscribe(() => {

this.router.navigate([

'/vacancies'

]);

});

}

}

}
