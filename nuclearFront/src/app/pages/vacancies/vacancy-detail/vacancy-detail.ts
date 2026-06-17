import {
Component,
OnInit,
inject
} from '@angular/core';

import {
ActivatedRoute
} from '@angular/router';

import {
VacancyService
} from '../../../core/services/vacancy.service';

import {
ApplicationService
} from '../../../core/services/application.service';

import {
AuthService
} from '../../../core/services/auth.service';

import {
ChangeDetectorRef
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

@Component({

selector:
'app-vacancy-detail',

standalone:
true,

imports:[
CommonModule
],

templateUrl:
'./vacancy-detail.html'

})

export class VacancyDetail
implements OnInit {

private route =
inject(
ActivatedRoute
);

private service =
inject(
VacancyService
);

private applicationService =
inject(
ApplicationService
);

private auth =
inject(
AuthService
);

private cd =
inject(
ChangeDetectorRef
);

vacancy:any;

role = '';

canApply = false;

message='';

ngOnInit(){

const id =
Number(

this.route.snapshot
.paramMap
.get(
'id'
)

);

this.role =
this.auth.getRole();

this.canApply =

this.role === 'EGRESADO'

||

this.role === 'COORDINADOR';

console.log(
'ID VACANTE:',
id
);

this.service
.findById(id)

.subscribe({

next:(v)=>{

this.vacancy = v;

this.cd.detectChanges();

},

error:(e)=>{

console.error(e);

}

});

}

apply(){

this.applicationService

.apply({

usuarioId:
this.auth.getUserId(),

vacanteId:
this.vacancy.id,

estado:
'ENVIADA',

fechaPostulacion:
new Date()
.toISOString(),

observaciones:
''

})

.subscribe({

next:()=>{

this.message =
'Postulación enviada';

},

error:()=>{

this.message =
'No fue posible aplicar';

}

});

}

}