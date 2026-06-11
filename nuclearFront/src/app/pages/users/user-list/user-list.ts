import {
Component,
OnInit,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router,
RouterModule
} from '@angular/router';

import {
UserService
} from '../../../core/services/user.service';

import {
User
} from '../../../core/models/user.model';

@Component({

selector:
'app-user-list',

standalone:
true,

imports: [

CommonModule,
RouterModule

],

templateUrl:
'./user-list.html',

styleUrl:
'./user-list.css'

})

export class UserList
implements OnInit {

private userService =
inject(
UserService
);

private router =
inject(
Router
);

users:
User[] =
[];

loading =
true;

error =
'';

ngOnInit(): void {

this.loadUsers();

}

loadUsers(): void {

this.loading =
true;

this.userService
.findAll()

.subscribe({

next:
(data) => {

this.users =
data;

this.loading =
false;

},

error:
(err) => {

console.error(
err
);

this.error =
'Error cargando usuarios';

this.loading =
false;

}

});

}

goToCreate(): void {

this.router.navigate([

'/users/new'

]);

}

goToEdit(
id: number
): void {

this.router.navigate([

'/users/edit',
id

]);

}

activate(
id: number
): void {

this.userService
.activate(id)

.subscribe(() => {

this.loadUsers();

});

}

deactivate(
id: number
): void {

this.userService
.deactivate(id)

.subscribe(() => {

this.loadUsers();

});

}

}
