import {
Component,
OnInit,
inject,
ChangeDetectorRef
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
ProfileService
}
from '../../core/services/profile.service';

import {
User
}
from '../../core/models/user.model';

@Component({

selector:'app-profile',

standalone:true,

imports:[
CommonModule
],

templateUrl:'./profile.html',

styleUrl:'./profile.css'

})

export class Profile
implements OnInit {

private profile =
inject(ProfileService);

private router =
inject(Router);

private cdr =
inject(ChangeDetectorRef);

user?: User;

loading = true;

ngOnInit(): void {

this.profile
.getProfile()

.subscribe({

next:(data)=>{

this.user = data;

this.loading = false;

this.cdr.detectChanges();

},

error:(e)=>{

console.error(e);

this.loading = false;

this.cdr.detectChanges();

}

});

}

edit(){

this.router.navigate([

'/profile/edit',
this.user?.id

]);

}
}