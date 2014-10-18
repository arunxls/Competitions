#!/usr/bin/perl
use strict;
use warnings;

sub insertionSort{
   	my (@array) = @_;

	foreach my $outer (reverse 0..$#array-1){
		if ($array[$outer]>$array[$outer+1]){
			my $var = $array[$outer+1];
			foreach my $inner (reverse 0..$outer){
				if ($array[$inner]>$var){
					$array[$inner+1] = $array[$inner];
					print_array(@array);
				} else {
					$array[$inner+1] = $var; 
					print_array(@array);
				}

				if($inner == 0){
					$array[0] = $var; 
					print_array(@array);
				}
			}
		}
   }
}

sub print_array
{
	my (@array) = @_;

	foreach (@array){
		chomp($_);
		print $_." ";
	}
	print "\n";
}
# Tail starts here
my $array_size = <>;
my @array = ();
$/ = ' ';
for (my $i = 0; $i < $array_size; $i++) {
   $array[$i] = int(<>);
}

insertionSort(@array);