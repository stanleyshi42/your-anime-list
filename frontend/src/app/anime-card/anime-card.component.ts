import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-anime-card',
  templateUrl: './anime-card.component.html',
  styleUrl: './anime-card.component.css',
})
export class AnimeCardComponent {
  @Input() anime: any;
}
