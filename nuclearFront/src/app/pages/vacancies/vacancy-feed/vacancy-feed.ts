import {
Component,
OnInit,
inject
}
from '@angular/core';

import {
CommonModule
}
from '@angular/common';

import {
Router
}
from '@angular/router';

import {
VacancyService
}
from '../../../core/services/vacancy.service';

import {
ChangeDetectorRef
}
from '@angular/core';

@Component({

selector:
'app-vacancy-feed',

standalone:true,

imports:[
CommonModule
],

templateUrl:
'./vacancy-feed.html',

styleUrls:[
'./vacancy-feed.css'
]

})

export class VacancyFeed
implements OnInit {

    private cd =
inject(
ChangeDetectorRef
);

private service =
inject(
VacancyService
);

private router =
inject(
Router
);

vacancies:
any[] = [];
ngOnInit(): void {

this.service
.findOpen()

.subscribe({

next:(data)=>{

this.vacancies=
data;

this.cd.detectChanges();

},

error:(e)=>{

console.error(e);

}

});

}

open(
id:number
){

this.router.navigate([

'/vacancies',
id

]);

}

}