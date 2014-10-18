#!/usr/bin/perl
use strict;
# use warnings;

my %table = ();

sub ncr
{
	my ($n,$r) = @_;

	return $table{"$n/$r"} if(exists $table{"$n/$r"});

	if($r == 1){
		return store_results($n,$r,$n,\%table)
	} elsif ($n == $r) {
		return store_results($n,$r,1,\%table);
	} elsif ($r == 0) {
		return store_results($n,$r,1,\%table);
	}
	return store_results($n,$r,(ncr($n-1,$r-1) + ncr($n-1,$r)),\%table);
}

# sub get_comb
# {
# 	my ($num) = @_;

# 	foreach (0..$num)
# 	{
# 		print store_results($num,$_,ncr($num,$_),\%table)." ";
# 	}
# 	print "\n";
# }

sub store_results
{
	my ($n,$r,$value,$hash) = @_;

	use integer;

	if(!exists $hash->{"$n/$r"}) {
		$value = $value %142857 ;
		$hash->{"$n/$r"} = $value;
		my $diff = $n-$r;
		$hash->{"$n/$diff"} = $value;
		return $value;
	}else {
		return $hash->{"$n/$r"};
	}
}

# #Tail starts here
# my $test_cases = <>;
# for (my $index = 0; $index < $test_cases; $index++)
# {
#     my $input = <>;
# 	print ncr(split(' ',$input))."\n";
# }

print ncr(10,5);
# get_comb(1000);
