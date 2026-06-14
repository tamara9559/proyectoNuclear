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
MonitoringService
} from '../../../core/services/monitoring.service';

import {
Monitoring
} from '../../../core/models/monitoring.model';

@Component({

selector:
'app-monitoring-form',

standalone:
true,

imports: [
CommonModule,
ReactiveFormsModule
],

templateUrl:
'./monitoring-form.html',

styleUrl:
'./monitoring-form.css'

})

export class MonitoringForm {

private fb =
inject(
FormBuilder
);

private service =
inject(
MonitoringService
);

private router =
inject(
Router
);

form =
this.fb.group({

practicaId:
[
null,
Validators.required
],

coordinadorId:
[
null,
Validators.required
],

tipoSeguimiento:
[
'VISITA'
],

descripcion:
[
''
]

});

save(): void {

if (
this.form.invalid
)
return;

const monitoring:
Monitoring = {

practicaId:
this.form.value.practicaId!,

coordinadorId:
this.form.value.coordinadorId!,

tipoSeguimiento:
this.form.value.tipoSeguimiento!,

descripcion:
this.form.value.descripcion ?? '',

fechaRegistro:
''

};

let request;

switch (
monitoring.tipoSeguimiento
) {

case
'VISITA':

request =
this.service
.registerVisit(
monitoring
);

break;

case
'OBSERVACION':

request =
this.service
.registerObservation(
monitoring
);

break;

case
'REUNION':

request =
this.service
.registerMeeting(
monitoring
);

break;

default:

request =
this.service
.registerCall(
monitoring
);

}

request.subscribe(
() => {

this.router.navigate([
'/monitorings'
]);

}
);

}

}