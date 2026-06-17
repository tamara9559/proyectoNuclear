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
Agreement
} from '../../../core/models/agreement.model';

import {
AgreementService
} from '../../../core/services/agreement.service';

@Component({

selector:
'app-agreement-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./agreement-list.html',

styleUrl:
'./agreement-list.css'

})

export class AgreementList
implements OnInit {

private service =
inject(
AgreementService
);

private router =
inject(
Router
);

agreements:
Agreement[] =
[];

ngOnInit(): void {

this.load();

}

load(): void {

this.service
.findAll()

.subscribe(

data => {

this.agreements =
data;

}

);

}

goToCreate(): void {

this.router.navigate([
'/agreements/new'
]);

}

goToEdit(
id: number
): void {

this.router.navigate([
'/agreements/edit',
id
]);

}

validate(
id: number
): void {

this.service
.validate(id)

.subscribe(() =>
this.load()
);

}

activate(
id: number
): void {

this.service
.activate(id)

.subscribe(() =>
this.load()
);

}

}