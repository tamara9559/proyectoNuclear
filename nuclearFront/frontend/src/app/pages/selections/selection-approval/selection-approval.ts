import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
ApplicationService
} from '../../../core/services/application.service';

import {
SelectionService
} from '../../../core/services/selection.service';

@Component({

selector:
'app-selection-approval',

standalone:true,

imports:[
CommonModule
],

templateUrl:
'./selection-approval.html'

})

export class SelectionApproval {

private app =
inject(
ApplicationService
);

private selection =
inject(
SelectionService
);

applications:any[]=[];

constructor(){

this.load();

}

load(){

this.app
.findAll()

.subscribe(

x=>{

this.applications =
x.filter(

a=>

a.estado
===
'EN_REVISION'

);

}

);

}

approve(
id:number
){

this.selection
.hireGraduate(
id
);

}

}