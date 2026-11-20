import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { firstValueFrom } from 'rxjs/internal/firstValueFrom';

export interface Utilisateur {
  readonly login: string;
  readonly roles: readonly string[];
}

/**
 * Garde l'utilisateur connecté. Squelette du TD : à compléter en partie 2.
 */
@Injectable({ providedIn: 'root' })
export class AuthService {
  readonly utilisateur = signal<Utilisateur | null>(null);
  private readonly http = inject(HttpClient);

  /**
   * Vérifie les identifiants auprès du serveur (GET /api/me avec l'en-tête
   * Basic) et mémorise l'utilisateur. Doit échouer (throw) si le serveur répond 401.
   */
  async connecter(login: string, motDePasse: string): Promise<void> {
    // TODO : appeler /api/me, retenir les identifiants pour l'intercepteur,
    // puis renseigner `utilisateur`.
    entete = 'Basic ' + btoa(`${login}:${motDePasse}`);
    return firstValueFrom(this.http.get<void>(`${API}/me`))
  }

  deconnecter(): void {
    // TODO : oublier les identifiants et l'utilisateur.
  }
}
