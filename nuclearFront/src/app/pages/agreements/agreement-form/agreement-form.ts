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
AgreementService
} from '../../../core/services/agreement.service';

import {
Agreement
} from '../../../core/models/agreement.model';

@Component({

selector:
'app-agreement-form',

standalone:
true,

imports: [

CommonModule,
ReactiveFormsModule

],

templateUrl:
'./agreement-form.html',

styleUrl:
'./agreement-form.css'

})

export class AgreementForm
implements OnInit {

private fb =
inject(FormBuilder);

private service =
inject(AgreementService);

private route =
inject(ActivatedRoute);

private router =
inject(Router);

editing =
false;

agreementId?:
number;

form =
this.fb.group({

empresaId: [
0,
Validators.required
],

tipoConvenio: [
'',
Validators.required
],

fechaInicio: [
''
],

fechaFin: [
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

this.agreementId =
Number(id);

this.load();

}

}

load(): void {

this.service
.findById(
this.agreementId!
)

.subscribe(

agreement => {

this.form.patchValue({

empresaId:
agreement.empresaId,

tipoConvenio:
agreement.tipoConvenio,

fechaInicio:
agreement.fechaInicio,

fechaFin:
agreement.fechaFin,

observaciones:
agreement.observaciones

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

const agreement: Agreement = {

id:
this.agreementId,

empresaId:
this.form.value.empresaId!,

tipoConvenio:
this.form.value.tipoConvenio!,

fechaInicio:
this.form.value.fechaInicio!,

fechaFin:
this.form.value.fechaFin!,

estado:
'BORRADOR',

firmadoEmpresa:
false,

firmadoUniversidad:
false,

firmadoEstudiante:
false,

certificadoCamaraComercio:
false,

validado:
false,

observaciones:
this.form.value.observaciones!

};

const request =
this.editing

? this.service.update(
this.agreementId!,
agreement
)

: this.service.create(
agreement
);

request.subscribe(() => {

this.router.navigate([
'/agreements'
]);

});

}

cancel(): void {

this.router.navigate([
'/agreements'
]);

}

}