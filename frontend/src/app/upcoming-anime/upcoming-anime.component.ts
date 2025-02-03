import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';

@Component({
  selector: 'app-upcoming-anime',
  templateUrl: './upcoming-anime.component.html',
  styleUrl: './upcoming-anime.component.css',
})
export class UpcomingAnimeComponent {
  upcomingAnime: any = [];
  constructor(private jikanService: JikanService) {}

  ngOnInit() {
    this.getUpcomingAnime();
  }

  getUpcomingAnime() {
    this.jikanService.getUpcoming().subscribe((data) => {
      this.upcomingAnime = data.data;
    });
  }
}
