import {
Component,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
FormsModule
} from '@angular/forms';

import {
Router
} from '@angular/router';

import {
Monitoring
} from '../../../core/models/monitoring.model';

import {
MonitoringService
} from '../../../core/services/monitoring.service';

@Component({

selector:
'app-monitoring-list',

standalone:
true,

imports: [
CommonModule,
FormsModule
],

templateUrl:
'./monitoring-list.html',

styleUrl:
'./monitoring-list.css'

})

export class MonitoringList {

private service =
inject(
MonitoringService
);

private router =
inject(
Router
);

practiceId =
0;

monitorings:
Monitoring[] =
[];

search(): void {

if (
!this.practiceId
)
return;

this.service
.history(
this.practiceId
)
.subscribe({

next:
data =>

this.monitorings =
data

});

}

newMonitoring(): void {

this.router.navigate([
'/monitorings/new'
]);

}

}