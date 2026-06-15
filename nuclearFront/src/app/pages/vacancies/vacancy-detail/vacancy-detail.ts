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

@Component({

selector:
'app-vacancy-detail',

standalone:
true,

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

vacancy:any;

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

this.service
.findById(id)

.subscribe(v=>{

this.vacancy =
v;

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