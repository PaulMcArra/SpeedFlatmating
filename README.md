Hi there!
Here is my solution.
I tried to stick as much as possible to the given Mockup.

I've made several assumptions for simplicity:
	The fields "startTime" and "endTime" in the JSON object always contain the same format.
	The JSON array is not empty.

I've used Volley and Picasso libraries because a find them easier to work with and more readable than others.
The RecyclerView is a good choice for efficiency and has become very popular.
I created a Venue class to hold the properties of each event. This could be implemented further by separating events and venues in different classes.
I used ACTION_DIAL as the Intent action because ACTION_CALL requires permission.
I included a drawable resource for rounding the corners of the "cost" element within the CardView.

Including a field like "venuePhoneNumber" in the JSON object would be useful for the phone call Intent.
And maybe including a field with the number of assistants to each event.
