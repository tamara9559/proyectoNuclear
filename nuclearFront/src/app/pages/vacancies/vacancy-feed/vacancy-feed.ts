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

@Component({

selector:
'app-vacancy-feed',

standalone:
true,

imports:[
CommonModule
],

templateUrl:
'./vacancy-feed.html',

styleUrl:
'./vacancy-feed.css'

})

export class VacancyFeed
implements OnInit {

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

.findAll()

.subscribe(

data=>{

this.vacancies =
data;

}

);

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