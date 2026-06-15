import {
Component,
OnInit,
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
'app-application-review',

standalone:true,

imports:[
CommonModule
],

templateUrl:
'./application-review.html'

})

export class ApplicationReview
implements OnInit {

private app =
inject(
ApplicationService
);

private selection =
inject(
SelectionService
);

applications:any[]=[];

ngOnInit(){

this.app

.findAll()

.subscribe(

r=>{

this.applications =
r;

}

);

}

accept(
id:number
){

this.selection
.acceptApplication(
id
);

}

reject(
id:number
){

this.selection
.rejectApplication(
id
);

}

}