import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';

@Component({
  selector: 'app-top-anime',
  templateUrl: './top-anime.component.html',
  styleUrl: './top-anime.component.css',
})
export class TopAnimeComponent {
  topAnime: any = [];
  constructor(private jikanService: JikanService) {}

  ngOnInit() {
    this.getTopAnime();
  }

  getTopAnime() {
    this.jikanService.getTop().subscribe((data) => {
      this.topAnime = data.data;
    });
  }
}
