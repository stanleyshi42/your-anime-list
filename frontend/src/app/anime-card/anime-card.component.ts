import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-anime-card',
  templateUrl: './anime-card.component.html',
  styleUrl: './anime-card.component.css',
})
export class AnimeCardComponent {
  // Anime model data
  @Input() anime: any;

  // Set values for the card to display
  // Ex: setting title and episodes to true will create a card displaying title and episodes
  @Input() title: boolean = false;
  @Input() episodes: boolean = false;
  @Input() score: boolean = false;
  @Input() aired_from: boolean = false;
}
