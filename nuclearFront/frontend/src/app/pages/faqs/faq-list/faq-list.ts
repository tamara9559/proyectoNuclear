import {
Component,
inject,
OnInit
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
Router
} from '@angular/router';

import {
FAQ
} from '../../../core/models/faq.model';

import {
FaqService
} from '../../../core/services/faq.service';

@Component({

selector:
'app-faq-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./faq-list.html',

styleUrl:
'./faq-list.css'

})

export class FaqList
implements OnInit {

private faqService =
inject(
FaqService
);

private router =
inject(
Router
);

faqs:
FAQ[] = [];

ngOnInit(): void {

this.load();

}

load(): void {

this.faqService
.findAll()
.subscribe({

next:
data =>
this.faqs =
data

});

}

newFaq(): void {

this.router.navigate([
'/faqs/new'
]);

}

edit(
id?: number
): void {

if (!id)
return;

this.router.navigate([
'/faqs/edit',
id
]);

}

toggle(
faq: FAQ
): void {

if (!faq.id)
return;

const action =
faq.estado
? this.faqService.deactivate(faq.id)
: this.faqService.activate(faq.id);

action.subscribe(() =>
this.load()
);

}

}