import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TopAnimeComponent } from './top-anime/top-anime.component';
import { UpcomingAnimeComponent } from './upcoming-anime/upcoming-anime.component';
import { AnimeDetailsComponent } from './anime-details/anime-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'top', component: TopAnimeComponent },
  { path: 'upcoming', component: UpcomingAnimeComponent },
  { path: 'anime/:id', component: AnimeDetailsComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
