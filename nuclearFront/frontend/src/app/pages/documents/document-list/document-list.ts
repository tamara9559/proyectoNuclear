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
Document
} from '../../../core/models/document.model';

import {
DocumentService
} from '../../../core/services/document.service';

@Component({

selector:
'app-document-list',

standalone:
true,

imports: [
CommonModule,
RouterModule
],

templateUrl:
'./document-list.html',

styleUrl:
'./document-list.css'

})

export class DocumentList
implements OnInit {

private service =
inject(
DocumentService
);

private router =
inject(
Router
);

documents:
Document[] =
[];

ngOnInit(): void {

this.load();

}

load(): void {

this.service
.findByStudent(
1
)
.subscribe(

data =>
this.documents =
data

);

}

create(): void {

this.router.navigate([
'/documents/new'
]);

}

remove(
id?: number
): void {

if (
!id
) {
return;
}

this.service
.delete(
id
)
.subscribe(() =>
this.load()
);

}

}