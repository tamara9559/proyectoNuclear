import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
MatchingService
} from '../../../core/services/matching.service';

@Component({

selector:
'app-ranking',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./ranking.html',

styleUrl:
'./ranking.css'

})

export class Ranking {

private service =
inject(
MatchingService
);

ranking =
[];

vacancyId =
1;

ngOnInit(): void {

this.service
.ranking(
this.vacancyId
)

.subscribe(

data => {

this.ranking =
data;

}

);

}

}