import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  airingAnime: any = [];
  constructor(private jikanService: JikanService) {}

  ngOnInit() {
    this.getAiringAnime();
  }

  getAiringAnime() {
    this.jikanService.getAiring().subscribe((data) => {
      this.airingAnime = data.data;
    });
  }
}
