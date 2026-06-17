import {
Component,
OnInit,
inject
} from '@angular/core';

import {
CommonModule
} from '@angular/common';

import {
StudentService
} from '../../../core/services/student.service';

import {
Student
} from '../../../core/models/student.model';

import {
Router
} from '@angular/router';

@Component({

selector:
'app-student-list',

standalone:
true,

imports: [
CommonModule
],

templateUrl:
'./student-list.html',

styleUrl:
'./student-list.css'

})

export class StudentList
implements OnInit {

private studentService =
inject(StudentService);

students:
Student[] = [];

loading =
true;

error =
'';

ngOnInit(): void {

this.loadStudents();

}

loadStudents(): void {

this.loading =
true;

this.studentService
.findAll()
.subscribe({

next: (
data
) => {

this.students =
data;

this.loading =
false;

},

error: () => {

this.error =
'No fue posible cargar estudiantes';

this.loading =
false;

}

});

}

private router =
inject(
Router
);



goToEdit(
id: number
): void {

this.router.navigate([

'/students/edit',
id

]);

}

}