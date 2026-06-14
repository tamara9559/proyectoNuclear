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
ApplicationService
} from '../../../core/services/application.service';

import {
Application
} from '../../../core/models/application.model';

@Component({

selector:
'app-application-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./application-list.html',

styleUrl:
'./application-list.css'

})

export class ApplicationList
implements OnInit {

private service =
inject(ApplicationService);

private router =
inject(Router);

applications:
Application[] =
[];

ngOnInit(): void {

this.load();

}

load(): void {

this.service
.findAll()

.subscribe(data => {

this.applications =
data;

});

}

goToCreate(): void {

this.router.navigate([
'/applications/new'
]);

}

}