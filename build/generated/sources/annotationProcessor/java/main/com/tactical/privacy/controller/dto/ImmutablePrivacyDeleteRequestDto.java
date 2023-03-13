package com.tactical.privacy.controller.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PrivacyDeleteRequestDto}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePrivacyDeleteRequestDto.builder()}.
 */
@Generated(from = "PrivacyDeleteRequestDto", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePrivacyDeleteRequestDto
    implements PrivacyDeleteRequestDto {
  private final long companyId;
  private final String phone;
  private final String email;

  private ImmutablePrivacyDeleteRequestDto(long companyId, String phone, String email) {
    this.companyId = companyId;
    this.phone = phone;
    this.email = email;
  }

  /**
   * @return The value of the {@code companyId} attribute
   */
  @JsonProperty("companyId")
  @Override
  public long getCompanyId() {
    return companyId;
  }

  /**
   * @return The value of the {@code phone} attribute
   */
  @JsonProperty("phone")
  @Override
  public String getPhone() {
    return phone;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @JsonProperty("email")
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyDeleteRequestDto#getCompanyId() companyId} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for companyId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyDeleteRequestDto withCompanyId(long value) {
    if (this.companyId == value) return this;
    return new ImmutablePrivacyDeleteRequestDto(value, this.phone, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyDeleteRequestDto#getPhone() phone} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for phone
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyDeleteRequestDto withPhone(String value) {
    String newValue = Objects.requireNonNull(value, "phone");
    if (this.phone.equals(newValue)) return this;
    return new ImmutablePrivacyDeleteRequestDto(this.companyId, newValue, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PrivacyDeleteRequestDto#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePrivacyDeleteRequestDto withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutablePrivacyDeleteRequestDto(this.companyId, this.phone, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePrivacyDeleteRequestDto} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePrivacyDeleteRequestDto
        && equalTo(0, (ImmutablePrivacyDeleteRequestDto) another);
  }

  private boolean equalTo(int synthetic, ImmutablePrivacyDeleteRequestDto another) {
    return companyId == another.companyId
        && phone.equals(another.phone)
        && email.equals(another.email);
  }

  /**
   * Computes a hash code from attributes: {@code companyId}, {@code phone}, {@code email}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + Longs.hashCode(companyId);
    h += (h << 5) + phone.hashCode();
    h += (h << 5) + email.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PrivacyDeleteRequestDto} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PrivacyDeleteRequestDto")
        .omitNullValues()
        .add("companyId", companyId)
        .add("phone", phone)
        .add("email", email)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PrivacyDeleteRequestDto", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PrivacyDeleteRequestDto {
    long companyId;
    boolean companyIdIsSet;
    @Nullable String phone;
    @Nullable String email;
    @JsonProperty("companyId")
    public void setCompanyId(long companyId) {
      this.companyId = companyId;
      this.companyIdIsSet = true;
    }
    @JsonProperty("phone")
    public void setPhone(String phone) {
      this.phone = phone;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
      this.email = email;
    }
    @Override
    public long getCompanyId() { throw new UnsupportedOperationException(); }
    @Override
    public String getPhone() { throw new UnsupportedOperationException(); }
    @Override
    public String getEmail() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePrivacyDeleteRequestDto fromJson(Json json) {
    ImmutablePrivacyDeleteRequestDto.Builder builder = ImmutablePrivacyDeleteRequestDto.builder();
    if (json.companyIdIsSet) {
      builder.companyId(json.companyId);
    }
    if (json.phone != null) {
      builder.phone(json.phone);
    }
    if (json.email != null) {
      builder.email(json.email);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PrivacyDeleteRequestDto} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PrivacyDeleteRequestDto instance
   */
  public static ImmutablePrivacyDeleteRequestDto copyOf(PrivacyDeleteRequestDto instance) {
    if (instance instanceof ImmutablePrivacyDeleteRequestDto) {
      return (ImmutablePrivacyDeleteRequestDto) instance;
    }
    return ImmutablePrivacyDeleteRequestDto.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePrivacyDeleteRequestDto ImmutablePrivacyDeleteRequestDto}.
   * <pre>
   * ImmutablePrivacyDeleteRequestDto.builder()
   *    .companyId(long) // required {@link PrivacyDeleteRequestDto#getCompanyId() companyId}
   *    .phone(String) // required {@link PrivacyDeleteRequestDto#getPhone() phone}
   *    .email(String) // required {@link PrivacyDeleteRequestDto#getEmail() email}
   *    .build();
   * </pre>
   * @return A new ImmutablePrivacyDeleteRequestDto builder
   */
  public static ImmutablePrivacyDeleteRequestDto.Builder builder() {
    return new ImmutablePrivacyDeleteRequestDto.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePrivacyDeleteRequestDto ImmutablePrivacyDeleteRequestDto}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PrivacyDeleteRequestDto", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements PrivacyDeleteRequestDto.Builder {
    private static final long INIT_BIT_COMPANY_ID = 0x1L;
    private static final long INIT_BIT_PHONE = 0x2L;
    private static final long INIT_BIT_EMAIL = 0x4L;
    private long initBits = 0x7L;

    private long companyId;
    private @Nullable String phone;
    private @Nullable String email;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PrivacyDeleteRequestDto} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PrivacyDeleteRequestDto instance) {
      Objects.requireNonNull(instance, "instance");
      companyId(instance.getCompanyId());
      phone(instance.getPhone());
      email(instance.getEmail());
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyDeleteRequestDto#getCompanyId() companyId} attribute.
     * @param companyId The value for companyId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("companyId")
    public final Builder companyId(long companyId) {
      this.companyId = companyId;
      initBits &= ~INIT_BIT_COMPANY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyDeleteRequestDto#getPhone() phone} attribute.
     * @param phone The value for phone 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("phone")
    public final Builder phone(String phone) {
      this.phone = Objects.requireNonNull(phone, "phone");
      initBits &= ~INIT_BIT_PHONE;
      return this;
    }

    /**
     * Initializes the value for the {@link PrivacyDeleteRequestDto#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("email")
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePrivacyDeleteRequestDto ImmutablePrivacyDeleteRequestDto}.
     * @return An immutable instance of PrivacyDeleteRequestDto
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePrivacyDeleteRequestDto build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePrivacyDeleteRequestDto(companyId, phone, email);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_COMPANY_ID) != 0) attributes.add("companyId");
      if ((initBits & INIT_BIT_PHONE) != 0) attributes.add("phone");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      return "Cannot build PrivacyDeleteRequestDto, some of required attributes are not set " + attributes;
    }
  }
}
