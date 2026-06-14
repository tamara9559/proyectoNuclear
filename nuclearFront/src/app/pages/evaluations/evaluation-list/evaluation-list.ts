import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router
} from '@angular/router';

import {
EvaluationService
} from '../../../core/services/evaluation.service';

import {
Evaluation
} from '../../../core/models/evaluation.model';

@Component({

selector:
'app-evaluation-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./evaluation-list.html',

styleUrl:
'./evaluation-list.css'

})

export class EvaluationList {

private service =
inject(
EvaluationService
);

private router =
inject(
Router
);

evaluations:
Evaluation[] =
[];

practiceId =
1;

average =
0;

load(): void {

this.service
.findByPractice(
this.practiceId
)

.subscribe(

data => {

this.evaluations =
data;

}

);

this.service
.average(
this.practiceId
)

.subscribe(

avg => {

this.average =
avg;

}

);

}

goToCreate(): void {

this.router.navigate([
'/evaluations/new'
]);

}

goToEdit(
id: number
): void {

this.router.navigate([
'/evaluations/edit',
id
]);

}

}