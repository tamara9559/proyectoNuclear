import {
Component
} from '@angular/core';

import {
RouterModule
} from '@angular/router';

import {
RouterLink,
RouterOutlet
} from '@angular/router';

@Component({

selector:
'app-layout',

standalone:
true,

imports: [
RouterModule,
RouterOutlet

],

templateUrl:
'./layout.html',

styleUrl:
'./layout.css'

})

export class Layout {

}