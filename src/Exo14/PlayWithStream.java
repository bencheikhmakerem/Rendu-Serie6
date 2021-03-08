package Exo14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




public class PlayWithStream {
	
	public static void main(String[] args) {
		
	
		List<String> strings=Arrays.asList("one","two","three","four","five",
									"six","seven","eight","nine","ten","eleven","twelve");
		
		//afficher le contenu du stream
			System.out.println("--Le contenu du stream--\n");
				  strings.stream()
				  		 .map(s->s.toString())
				  		 .forEach( System.out::println );
		 
		 //mettre le contenu du stream en majuscule

			System.out.println("--Le contenu du stream en MAJUSCULE--\n"); 
					strings.stream()
						   .map(s ->s.toUpperCase())
						   .forEach( System.out::println );
		//afficher les premiers lettres en maj et sans doublons
			System.out.println("--Le contenu du stream en MAJUSCULE et sans doublons--\n"); 
				   strings.stream()
				   		  .map(s ->s.substring(0,1).toUpperCase())
				   		  .distinct()
				   		  .forEach( System.out::println );
		//afficher les longueurs du stream sans doublons

			 System.out.println("--Le contenu du stream en MAJUSCULE et sans doublons--\n"); 
				  strings.stream()
				   		  .map(s ->s.length())
				   		  .distinct()
				   		  .forEach( System.out::println );
		 //afficher le nombre d"éléments de ce stream

			 System.out.println("--Le nombre des elements de stream--\n"); 
			 long L=strings.stream()
						   .collect(Collectors.counting());
			System.out.println("nombre des élements : " +L);
		//afficher le nombre d"éléments à longueur paire de ce stream

			 System.out.println("--Le nombre des elements de stream--\n"); 
			 long LPaire=strings.stream()
					 			.filter(s->s.length()%2==0)
					 			.collect(Collectors.counting());
			 System.out.println("nombre des élements : " +LPaire);
		//
			//afficher la chaine la plus longue de ce stream

			System.out.println("--La chaine la plus longue du stream--\n"); 
			 			int LongMax= 
			 			 strings.stream()
					 			.mapToInt(String::length).max().getAsInt();
					 			
			 System.out.println("Longueur de la chaine : " +LongMax);
		
			 //liste qui contient les chaines de longueur impaire et en maj
			 System.out.println("liste des chaines de longueur impaire et en maj");

			 List<String> ChaineMaj= 
					      strings.stream()
					      		 .filter(s->(s.length()%2!=0))
					      		 .map(s->s.toUpperCase())
					      		 .collect(Collectors.toList());
			 System.out.println(ChaineMaj);
		//liste résultante de concaténation et trié dans l'ordre alphabétique
			 System.out.println("liste des chaines concaténées");

			 String liste= 
					 strings.stream()
		      		 .filter(s->(s.length()<=5))
		      		 .sorted()
		      		 .collect(Collectors.joining(",","{","}"));
		 
			 System.out.println(liste);
			 
		//table de hachage
			 System.out.println("la table de hachage");
			 
			 Map<Integer, List<String>> map=
					        strings.stream()
					        	   .collect(Collectors.groupingBy(String::length));
			 System.out.println("la table ordonnée par longueur\n");
			 map.forEach((key,value)->System.out.println(key + "=" + value));
	    //table de hachage à partie des premiers lettre
			 
			 Map<Character, String> map2=
				            strings.stream()
				        	   	   .collect( Collectors.groupingBy(s->s.charAt(0),Collectors.joining(",")));
				        	   	   
				        	   	   			   
			 					   
			 System.out.println("la table ordonnée par premiere lettre\n");
			 map2.forEach((key,value)->System.out.println(key + "=" + value));

			 

			 

	}							
}

