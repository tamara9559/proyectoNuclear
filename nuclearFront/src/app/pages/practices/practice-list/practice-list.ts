import {
Component,
OnInit,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router
} from '@angular/router';

import {
PracticeService
} from '../../../core/services/practice.service';

import {
Practice
} from '../../../core/models/practice.model';

@Component({

selector:
'app-practice-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./practice-list.html',

styleUrl:
'./practice-list.css'

})

export class PracticeList
implements OnInit {

private service =
inject(
PracticeService
);

private router =
inject(
Router
);

practices:
Practice[] =
[];

ngOnInit(): void {

this.load();

}

load(): void {

this.service
.findAll()

.subscribe(
data => {

this.practices =
data;

}
);

}

goToCreate(): void {

this.router.navigate([
'/practices/new'
]);

}

goToEdit(
id: number
): void {

this.router.navigate([
'/practices/edit',
id
]);

}

}