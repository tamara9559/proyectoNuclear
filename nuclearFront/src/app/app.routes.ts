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

export const routes: Routes = [

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
path: 'students',
component: StudentList
},

{
path: 'students/new',
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
path: 'vacancies',
component: VacancyList
},

{
path: 'vacancies/new',
component: VacancyForm
},

{
path: '**',
component: NotFound
}

];