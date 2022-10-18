package com.stockManager.sinda.exception;

public enum ErrorsCodes {

	

		ARTICLE_NOT_FOUND((long) 1000),
		ARTICLE_NOT_VALID((long) 1001),
		CATEGORIES_NOT_FOUND((long) 2000),
		CATEGORIES_NOT_VALID((long) 2001),
		CLIENT__NOT_FOUND((long) 3000),
		CLIENT_NOT_VALID((long) 3001),
		CMD_CLIENT__NOT_FOUND((long) 4000),
		CMD_CIENT_NOT_VALID((long) 4001),
		CMD_FOURNISSEUR__NOT_FOUND((long) 5000),
		CMD_FOURNISEUR_NOT_VALID((long) 5001),
		COMPANY__NOT_FOUND((long) 6000),
		COMPANY_NOT_VALID((long) 6001),
		FOURNISSEUR__NOT_FOUND((long) 7000),
		FOURNISSEUR_NOT_VALID((long) 7001),
		LIGNE_CMD_CLIENT__NOT_FOUND((long) 8000),
		LIGNE_CMD_CLIENT_NOT_VALID((long) 8001),
		LIGNE_CMD_FOURNISSEUR__NOT_FOUND((long) 9000),
		LIGNE_CMD_FOURNISSUER_NOT_VALID((long) 9001),
		LIGNE_VENTE__NOT_FOUND((long) 10000),
		LIGNE_VENTE_NOT_VALID((long) 10001),
		MVMT_STCK__NOT_FOUND((long) 11000),
		MVMT_STCK_NOT_VALID((long) 11001),
		ROLES__NOT_FOUND((long) 12000),
		ROLES_NOT_VALID((long) 12001),
		UTILISATEUR__NOT_FOUND((long) 13000),
		UTILISATUER_NOT_VALID((long) 13001),
		VENTE__NOT_FOUND((long) 14000),
		VENTE_NOT_VALID((long) 14001),
		;
		
		private Long code;
		ErrorsCodes(Long code){
			this.code = code;
		}
		public Long getCode() {
			return code;
		}
		
		
	}

