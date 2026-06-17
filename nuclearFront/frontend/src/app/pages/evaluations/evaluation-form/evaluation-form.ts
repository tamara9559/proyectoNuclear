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
EvaluationService
} from '../../../core/services/evaluation.service';

import {
Evaluation
} from '../../../core/models/evaluation.model';

@Component({

selector:
'app-evaluation-form',

standalone:
true,

imports: [

CommonModule,
ReactiveFormsModule

],

templateUrl:
'./evaluation-form.html',

styleUrl:
'./evaluation-form.css'

})

export class EvaluationForm
implements OnInit {

private fb =
inject(FormBuilder);

private service =
inject(EvaluationService);

private route =
inject(ActivatedRoute);

private router =
inject(Router);

editing =
false;

evaluationId?:
number;

form =
this.fb.group({

practicaId: [
0,
Validators.required
],

evaluador: [
'',
Validators.required
],

calificacion: [
0,
Validators.required
],

fortalezas: [
''
],

oportunidadesMejora: [
''
],

observaciones: [
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

if (id) {

this.editing =
true;

this.evaluationId =
Number(id);

this.load();

}

}

load(): void {

this.service
.findById(
this.evaluationId!
)

.subscribe(

evaluation => {

this.form.patchValue({

practicaId:
evaluation.practicaId,

evaluador:
evaluation.evaluador,

calificacion:
evaluation.calificacion,

fortalezas:
evaluation.fortalezas,

oportunidadesMejora:
evaluation.oportunidadesMejora,

observaciones:
evaluation.observaciones

});

}

);

}

save(): void {

if (
this.form.invalid
) {

this.form.markAllAsTouched();

return;

}

const evaluation: Evaluation = {

id:
this.evaluationId,

practicaId:
this.form.value.practicaId!,

evaluador:
this.form.value.evaluador!,

calificacion:
this.form.value.calificacion!,

fortalezas:
this.form.value.fortalezas!,

oportunidadesMejora:
this.form.value.oportunidadesMejora!,

observaciones:
this.form.value.observaciones!,

fechaEvaluacion:
new Date()
.toISOString()
.substring(
0,
10
)

};

const request =
this.editing

? this.service.update(
this.evaluationId!,
evaluation
)

: this.service.create(
evaluation
);

request.subscribe(() => {

this.router.navigate([
'/evaluations'
]);

});

}

cancel(): void {

this.router.navigate([
'/evaluations'
]);

}

}