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

import { NotFound } from './pages/not-found/not-found';

import {
Layout
} from './shared/layout/layout/layout';

import { Ranking } from './pages/matching/ranking/ranking';

import { SelectionActions } from './pages/selections/selection-actions';

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
}

]


},

{
path: '**',
component: NotFound
}

];