import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {
Loader
}
from './shared/components/loader/loader';
imports: [

RouterOutlet,

Loader

]

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('nuclearFront');
}
