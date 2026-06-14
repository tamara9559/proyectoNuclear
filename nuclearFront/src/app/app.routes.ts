import { Routes } from '@angular/router';

import { Dashboard } from './pages/dashboard/dashboard';

import { UserList } from './pages/users/user-list/user-list';
import { UserForm } from './pages/users/user-form/user-form';

import { StudentList } from './pages/students/student-list/student-list';
import { StudentForm } from './pages/students/student-form/student-form';

import { CompanyList } from './pages/companies/company-list/company-list';
import { CompanyForm } from './pages/companies/company-form/company-form';

import { VacancyList } from './pages/vacancies/vacancy-list/vacancy-list';
import { VacancyForm } from './pages/vacancies/vacancy-form/vacancy-form';

import { NotFound } from './pages/errors/not-found/not-found';

import {
Layout
} from './shared/layout/layout/layout';

import { Ranking } from './pages/matching/ranking/ranking';

import { SelectionActions } from './pages/selections/selection-actions';

import { ApplicationList }
from './pages/applications/application-list/application-list';

import { ApplicationForm }
from './pages/applications/application-form/application-form';

import { AgreementList }
from './pages/agreements/agreement-list/agreement-list';

import { AgreementForm }
from './pages/agreements/agreement-form/agreement-form';

import {
EvaluationList
}
from
'./pages/evaluations/evaluation-list/evaluation-list';

import {
EvaluationForm
}
from
'./pages/evaluations/evaluation-form/evaluation-form';

import {
PracticeList
} from './pages/practices/practice-list/practice-list';

import {
PracticeForm
} from './pages/practices/practice-form/practice-form';

import {
DocumentList
}
from
'./pages/documents/document-list/document-list';

import {
DocumentForm
}
from
'./pages/documents/document-form/document-form';

import {
FaqList
}
from './pages/faqs/faq-list/faq-list';

import {
FaqForm
}
from './pages/faqs/faq-form/faq-form';

import {
MonitoringList
}
from './pages/monitorings/monitoring-list/monitoring-list';

import {
MonitoringForm
}
from './pages/monitorings/monitoring-form/monitoring-form';

import {
authGuard
}
from './core/guards/auth.guard';

import {
guestGuard
}
from './core/guards/guest.guard';

import {
Login
}
from './pages/login/login';

export const routes: Routes = [

{

path: '',

component: Layout,

children: [

{
path: '',
component: Dashboard
},

{
path: 'users',
component: UserList
},

{
path: 'users/new',
component: UserForm
},

{
path: 'users/edit/:id',
component: UserForm
},

{
path: 'students',
component: StudentList
},

{
path: 'students/new',
component: StudentForm
},

{
path: 'students/edit/:id',
component: StudentForm
},

{
path: 'companies',
component: CompanyList
},

{
path: 'companies/new',
component: CompanyForm
},

{
path: 'companies/edit/:id',
component: CompanyForm
},

{
path: 'vacancies',
component: VacancyList
},

{
path: 'vacancies/new',
component: VacancyForm
},

{
path: 'vacancies/edit/:id',
component: VacancyForm
},

{
path:
'matching',

component:
Ranking
},

{
path:
'selection',

component:
SelectionActions
},

{
path:
'applications',

component:
ApplicationList
},

{
path:
'applications/new',

component:
ApplicationForm
},

{
path:
'agreements',

component:
AgreementList
},

{
path:
'agreements/new',

component:
AgreementForm
},

{
path:
'agreements/edit/:id',

component:
AgreementForm
},

{
path:
'evaluations',
component:
EvaluationList
},

{
path:
'evaluations/new',
component:
EvaluationForm
},

{
path:
'evaluations/edit/:id',
component:
EvaluationForm
},

{
path:
'practices',
component:
PracticeList
},

{
path:
'practices/new',
component:
PracticeForm
},

{
path:
'practices/edit/:id',
component:
PracticeForm
},

{
path:
'documents',

component:
DocumentList
},

{
path:
'documents/new',

component:
DocumentForm
},

{
path:
'faqs',

component:
FaqList
},

{
path:
'faqs/new',

component:
FaqForm
},

{
path:
'faqs/edit/:id',

component:
FaqForm
},

{
path:
'monitorings',

component:
MonitoringList
},

{
path:
'monitorings/new',

component:
MonitoringForm
},

{
path:
'**',

loadComponent:
() =>

import(
'./pages/errors/not-found/not-found'
)

.then(
m =>
m.NotFound
)

},

{

path:
'dashboard',

component:
Dashboard,

canActivate:
[
authGuard
]

},

{

path:
'login',

component:
Login,

canActivate:
[
guestGuard
]

}

]

},


];